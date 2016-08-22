package au.com.agic.apptesting.utils;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;

/**
 * A service for automatically extracting and configuring web drivers
 */
public interface WebDriverHandler {
	/**
	 * Extracts the integrated web driver and configures the system properties
	 */
	void configureWebDriver(@NotNull final List<File> tempFiles);
}
