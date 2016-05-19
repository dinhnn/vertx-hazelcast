package io.vertx.spi.cluster.hazelcast.impl.serializable;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;

import io.vertx.core.json.JsonObject;

public class JsonDataSerializable extends BuiltinClusterDataSerializable<JsonObject> {

	public JsonDataSerializable(){
		
	}
	
	public JsonDataSerializable(JsonObject obj){
		super(obj);
	}
	@Override
	public int getId() {
		return 1;
	}
	@Override
	public void writeData(ObjectDataOutput objectDataOutput) throws IOException {
		objectDataOutput.writeUTF(clusterSerializable.encode());
	}
	@Override
	public void readData(ObjectDataInput objectDataInput) throws IOException {
		clusterSerializable = new JsonObject(objectDataInput.readUTF());
	}

}
