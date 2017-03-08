public class Loc {

	public Lang l;
	boolean inComment;
	boolean invalid = false;

	public void setLanguage(String s){
		if (s.trim().endsWith(".java")){
			l = Lang.JAVA;
		} else if(s.trim().endsWith(".cpp")){
			l = Lang.CPP;
		} else if(s.trim().endsWith(".c")){
			l = Lang.C;
		} else if(s.trim().endsWith(".py")){
			l = Lang.PYTHON;
		} else {
			System.out.println("Lenguaje no valido");
			invalid = true;
		}
	}

	public boolean checkString (String line){
		
		if (invalid) return false;

		switch(l){

		case JAVA:
		case CPP:

			if(line.trim().startsWith("//")){
				return false;
			}

			if(line.trim().endsWith("*/") && inComment){
				inComment = false;
				return false;
			}

			if (line.trim().startsWith("/*")){
				inComment = true;
				return false;
			}
			
			if(line.trim().isEmpty()){
				return false;
			}

			if(inComment){
				return false;
			}
			
			return true;

		case PYTHON:
			
			if(line.trim().startsWith("#")){
				return false;
			}
			
			return true;
			
		case C:
			
			if(line.trim().endsWith("*/") && inComment){
				inComment = false;
				return false;
			}

			if (line.trim().startsWith("/*")){
				inComment = true;
				return false;
			}
			
			if(line.trim().isEmpty()){
				return false;
			}

			if(inComment){
				return false;
			}
			
			return true;
			
				
		default:
			return true;
		}

	}
}
