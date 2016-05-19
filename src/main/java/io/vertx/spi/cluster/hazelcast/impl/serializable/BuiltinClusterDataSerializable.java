package io.vertx.spi.cluster.hazelcast.impl.serializable;

import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

import io.vertx.core.shareddata.impl.ClusterSerializable;

public abstract class BuiltinClusterDataSerializable<T extends ClusterSerializable> implements IdentifiedDataSerializable {
	
	public T clusterSerializable;
	
	public BuiltinClusterDataSerializable(T clusterSerializable){
		this.clusterSerializable = clusterSerializable;
	}
	public BuiltinClusterDataSerializable(){
		
	}
	@Override
	public int getFactoryId() {
		return VertxDataSerializerHook.FACTORY_ID;
	}

}
