/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.remoting.support;

import org.springframework.util.Assert;

/**
 * Abstract base class for classes that access a remote service.
 * Provides a "serviceInterface" bean property.
 * 用于访问远程服务的类的抽象基类。
 * <p>Note that the service interface being used will show some signs of
 * remotability, like the granularity of method calls that it offers.
 * Furthermore, it has to have serializable arguments etc.
 * 请注意，所使用的服务接口将显示一些可删除的迹象，比如它提供的方法调用的粒度。
 * 此外，它必须有可序列化的参数等等。
 * <p>Accessors are supposed to throw Spring's generic
 * {@link org.springframework.remoting.RemoteAccessException} in case
 * of remote invocation failure, provided that the service interface
 * does not declare {@code java.rmi.RemoteException}.
 *
 * @author Juergen Hoeller
 * @since 13.05.2003
 * @see org.springframework.remoting.RemoteAccessException
 * @see java.rmi.RemoteException
 */
public abstract class RemoteAccessor extends RemotingSupport {

	private Class<?> serviceInterface;


	/**
	 * Set the interface of the service to access.
	 * The interface must be suitable for the particular service and remoting strategy.
	 * <p>Typically required to be able to create a suitable service proxy,
	 * but can also be optional if the lookup returns a typed proxy.
	 */
	public void setServiceInterface(Class<?> serviceInterface) {
		Assert.notNull(serviceInterface, "'serviceInterface' must not be null");
		Assert.isTrue(serviceInterface.isInterface(), "'serviceInterface' must be an interface");
		this.serviceInterface = serviceInterface;
	}

	/**
	 * Return the interface of the service to access.
	 */
	public Class<?> getServiceInterface() {
		return this.serviceInterface;
	}

}
