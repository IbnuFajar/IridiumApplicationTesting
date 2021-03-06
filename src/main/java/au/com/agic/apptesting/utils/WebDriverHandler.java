package au.com.agic.apptesting.utils;

import java.io.File;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * A service for automatically extracting and configuring web drivers
 */
public interface WebDriverHandler {
	/**
	 * Extracts the integrated web driver and configures the system properties
	 * @param tempFiles A collection to place references to any temporary files in
	 */
	void configureWebDriver(@NotNull List<File> tempFiles);
}
