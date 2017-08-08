
package com.skynet.retailscm.storagespace;
import com.skynet.retailscm.EntityNotFoundException;

public class StorageSpaceVersionChangedException extends StorageSpaceManagerException {
	private static final long serialVersionUID = 1L;
	public StorageSpaceVersionChangedException(String string) {
		super(string);
	}

}


