package com.skynet.infrastructure;

import java.util.List;

public interface GraphService {

	List<String[]> relationsOf(String fromLabel, String fromId, String toLable, String toId);

}
