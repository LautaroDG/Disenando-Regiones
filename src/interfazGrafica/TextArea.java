package interfazGrafica;

public class TextArea 
{
	private boolean lineWrap;
	private String text;
	private String font;
	private boolean editable;
	private String[] bounds;
	
	public TextArea (	 String[] bounds,	 String text,	 String font,	 boolean lineWrap, boolean editable) 
	{
		this.bounds= bounds;
		this.text= text;
		this.font = font;
		this.lineWrap = lineWrap;
		this.editable = editable;		
	}

	public boolean isLineWrap() {
		return lineWrap;
	}

	public void setLineWrap(boolean lineWrap) {
		this.lineWrap = lineWrap;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String[] getBounds() {
		return bounds;
	}

	public void setBounds(String[] bounds) {
		this.bounds = bounds;
	}
	
	
	
}
