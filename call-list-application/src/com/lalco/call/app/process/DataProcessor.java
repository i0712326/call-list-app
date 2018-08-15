package com.lalco.call.app.process;

import java.io.IOException;
import java.util.List;

import com.lalco.call.app.entity.Entity;

public interface DataProcessor {
	public void listProcessor() throws IOException;
	public List<Entity> getNormalList();
	public List<Entity> getErrorList();
}
