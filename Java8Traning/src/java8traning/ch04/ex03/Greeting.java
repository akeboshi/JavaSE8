package java8traning.ch04.ex03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {
	private String text;
	private StringProperty property = null;

	public Greeting (String defaultText) {
		this.text = defaultText;
	}
	
	public final StringProperty textProperty() {
		if (property == null) {
			property = new SimpleStringProperty("");
		}
		return property;
	}

	public final void setText(String newValue) {
		if (property == null) {
			text = newValue;
		} else {
			property.set(newValue);
		}
	}

	public final String getText() {
		return property == null ? text : property.get();
	}
}
