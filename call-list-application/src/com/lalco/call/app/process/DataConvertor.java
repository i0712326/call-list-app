package com.lalco.call.app.process;

import java.io.IOException;
import java.util.List;

import com.lalco.call.app.entity.Entity;

public interface DataConvertor {
	public void exportExcel(List<Entity> list, String fileName) throws IOException;
}
