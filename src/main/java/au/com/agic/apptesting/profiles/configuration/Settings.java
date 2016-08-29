package au.com.agic.apptesting.profiles.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a {@code <settings>} element
 */
public class Settings {

	private List<DesiredCapabilities> desiredCapabilities = new ArrayList<>();

	@XmlElement(name = "desiredCapabilities")
	public List<DesiredCapabilities> getDesiredCapabilities() {
		return desiredCapabilities;
	}

	public void setDesiredCapabilities(final List<DesiredCapabilities> desiredCapabilities) {
		this.desiredCapabilities = new ArrayList<>(desiredCapabilities);
	}
}
