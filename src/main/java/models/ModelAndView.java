package models;

public class ModelAndView {
	private Object item;
	private String filePath;

	public ModelAndView(Object item, String filePath) {
		this.item = item;
		this.filePath = filePath;
	}

	public Object getModel() {
		return item;
	}

	public String getViewName() {
		return filePath;
	}
}
