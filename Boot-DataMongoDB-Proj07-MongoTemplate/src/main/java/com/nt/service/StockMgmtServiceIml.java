package com.nt.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.StockDetails;

@Service("stockService")
public class StockMgmtServiceIml implements IStockMgmtService {

	@Autowired
	private MongoTemplate template;

	@Override
	public String registerStockDetails(StockDetails details) {

		int idValue = template.save(details, "Stock").getStockId();// given doc object data will be saved by creating
																	// collection called "Stock"
		int idValue1 = template.insert(details).getStockId();// given doc object data will be saved by createing
																// collection with the document class name

		int idValue2 = template.save(details).getStockId(); // given doc object will be saved by creating collection
															// with Document class name
		return "Document is saved with id value:: " + idValue;
	}

	@Override
	public String registerStockDetailsByBatch(List<StockDetails> list) {

		int size = template.insertAll(list).size();
		return size + " no.of documents are saved";
	}

	@Override
	public List<StockDetails> fetchStockDetailsByExchange(String exchange) {
		// prepare Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("exchangeName").is(exchange)); // where exchange=?0
		// execute query
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public List<StockDetails> fetchStockDetailsByPriceRange(double startPrice, double endPrice) {
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).lte(endPrice));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public StockDetails fetchStockDetailsByStockId(int stockId) {

		return template.findById(stockId, StockDetails.class);
	}

	@Override
	public String modifyExchangeByStockPriceRange(double startPrice, double endPrice, String newExchangeName) {
		// Query object for single doc retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).andOperator(Criteria.where("price").lte(endPrice)));
		// update object
		Update update = new Update().set("exchangeName", newExchangeName);
		// call the method
		UpdateResult result = template.updateMulti(query, update, StockDetails.class);
		return result.getModifiedCount() + " no.of reocred ared effected";
	}

	@Override
	public String registerOrUpdateStockByStockName(String stockName, double newPrice, String newExchange) {

		// Query object for single doc retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));

		// update object
		Update update = new Update();
		update.set("exchangeName", newExchange);
		// update.set("stockName", stockName);
		// update.set("stockId", new Random().nextInt(1000));
		update.set("price", newPrice);

		// invoke the methhod
		UpdateResult result = template.upsert(query, update, StockDetails.class);
		if (result.getModifiedCount() == 0) {
			return "new Document is inserted with id value:: " + result.getUpsertedId();
		} else {
			return "Existing doc is updated";
		}

	}

	@Override
	public String fetchAndRemoveByStockName(String stockName) {

		// Query object for single doc retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		// call the mthod
		StockDetails details = template.findAndRemove(query, StockDetails.class);

		return details == null ? "stock not found" : " stock found and delete";
	}

}
