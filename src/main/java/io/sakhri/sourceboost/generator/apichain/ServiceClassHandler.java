package io.sakhri.sourceboost.generator.apichain;

public class ServiceClassHandler extends AbstractHandler {

	
	public ServiceClassHandler(Request request) {
		
		super(new FacadeClassHandler(request), request);
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub

	}

}
