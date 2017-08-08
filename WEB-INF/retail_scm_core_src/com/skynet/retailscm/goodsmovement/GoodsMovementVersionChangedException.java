
package com.skynet.retailscm.goodsmovement;
import com.skynet.retailscm.EntityNotFoundException;

public class GoodsMovementVersionChangedException extends GoodsMovementManagerException {
	private static final long serialVersionUID = 1L;
	public GoodsMovementVersionChangedException(String string) {
		super(string);
	}

}


