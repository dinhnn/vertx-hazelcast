package io.vertx.spi.cluster.hazelcast.impl.serializable;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;

import io.vertx.core.buffer.Buffer;

public class BufferDataSerializable extends BuiltinClusterDataSerializable<Buffer> {
	
	public BufferDataSerializable(Buffer buff){
		super(buff);
	}
	public BufferDataSerializable(){
		
	}

	@Override
	public int getId() {
		return 0;
	}
	@Override
	public void readData(ObjectDataInput objectDataInput) throws IOException {
		int length = objectDataInput.readInt();
		byte[] buff = new byte[length];
		objectDataInput.readFully(buff);
		clusterSerializable = Buffer.buffer(length);
	}
	@Override
	public void writeData(ObjectDataOutput objectDataOutput) throws IOException {
		objectDataOutput.writeInt(clusterSerializable.length());
		objectDataOutput.write(clusterSerializable.getBytes());
	}

}
