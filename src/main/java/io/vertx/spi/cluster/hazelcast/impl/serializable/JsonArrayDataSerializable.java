package io.vertx.spi.cluster.hazelcast.impl.serializable;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;

import io.vertx.core.json.JsonArray;

public class JsonArrayDataSerializable extends BuiltinClusterDataSerializable<JsonArray> {
	public JsonArrayDataSerializable(){
		
	}
	public JsonArrayDataSerializable(JsonArray obj){
		super(obj);
	}
	@Override
	public int getId() {
		return 2;
	}
	@Override
	public void readData(ObjectDataInput objectDataInput ) throws IOException {
		clusterSerializable = new JsonArray(objectDataInput.readUTF());
	}
	@Override
	public void writeData(ObjectDataOutput objectDataOutput) throws IOException {
		objectDataOutput.writeUTF(clusterSerializable.encode());
	}
}
