package io.sakhri.sourceboost.generator.apichain;


public class FacadeClassHandler extends AbstractHandler {

	public FacadeClassHandler(Request request) {
		
		super(new ControllerClassHandler(request), request);
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub

	}

}
