package logic.view;

public class ViewJFXFactory {
	
	private static ViewJFXFactory ref = null;
	
	public static ViewJFXFactory getReference() {
		if (ref == null) {
			ref = new ViewJFXFactory();
		}
		
		return ref;
	}
	
	public ViewJFX getView(Theme theme) {
		String className = ViewJFXClassic.class.getName();
		try {
			return (ViewJFX) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
