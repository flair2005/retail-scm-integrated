
package com.skynet.retailscm.goods;
import com.skynet.retailscm.EntityNotFoundException;

public class GoodsVersionChangedException extends GoodsManagerException {
	private static final long serialVersionUID = 1L;
	public GoodsVersionChangedException(String string) {
		super(string);
	}

}


