package tangxiaotang.code.generater.application.util;

import org.apache.commons.lang.StringUtils;
import tangxiaotang.code.generater.application.config.Config;
import tangxiaotang.code.generater.application.db.Table;
import tangxiaotang.code.generater.application.model.Context;

public abstract class AbstractGenerator  implements ICodeGenerator{

    public abstract void generate(Table table, Context context)throws Exception ;

	protected String getFilePath(Table table) {
		Config cfg = table.getDatabase().getCfg();
		return cfg.getFilepath();
	}
	
	protected String getPackagePath(Table table) {
		StringBuilder path = new StringBuilder();
		Config cfg = table.getDatabase().getCfg();
		String[] dirs = StringUtils.split(cfg.getPackageName(), "\\.");
		for (int i = 0; i < dirs.length; i++) {
			path.append("/").append(dirs[i]);
		}
		return path.toString();
	}
	
}
