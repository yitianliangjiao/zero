package com.wrh.model;

import java.io.File;


public class upload {

private String chunks;

private String chunk;

private String size;

private String name;

private String guid;

private String md5;


public String getMd5() {
	return md5;
}

public void setMd5(String md5) {
	this.md5 = md5;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getChunks() {
	return chunks;
}

public void setChunks(String chunks) {
	this.chunks = chunks;
}

public String getChunk() {
	return chunk;
}

public void setChunk(String chunk) {
	this.chunk = chunk;
}

public String getGuid() {
	return guid;
}

public void setGuid(String guid) {
	this.guid = guid;
}
}
