package com.nt.service;

import com.nt.entity.CallerTuneInfo;

public interface ICallerTuneMgmtService {

	public String saveCallerTuneInfo(CallerTuneInfo info);

	public String updateTuneInfoById(Integer id, String tunename, String movieName);

	public CallerTuneInfo showCallerTuneDetails(Integer id);
	
}
