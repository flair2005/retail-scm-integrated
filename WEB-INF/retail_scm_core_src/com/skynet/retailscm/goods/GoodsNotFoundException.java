
package com.skynet.retailscm.goods;
import com.skynet.retailscm.EntityNotFoundException;
public class GoodsNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public GoodsNotFoundException(String string) {
		super(string);
	}

}

