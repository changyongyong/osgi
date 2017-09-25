package com.unmi.login.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.unmi.login.service.Validator;
import com.unmi.login.service.impl.FileValidatorBundle;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceReg = null;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("启动File");
		serviceReg = bundleContext
				.registerService(Validator.class.getName(), new FileValidatorBundle(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("停止File");
		if (serviceReg != null) {
			serviceReg.unregister();
		}
	}

}
