
package com.skynet.retailscm.skilltype;
import com.skynet.retailscm.EntityNotFoundException;

public class SkillTypeVersionChangedException extends SkillTypeManagerException {
	private static final long serialVersionUID = 1L;
	public SkillTypeVersionChangedException(String string) {
		super(string);
	}

}


