package springdi.z01_vo;
//springdi.z01_vo.Exp0308
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Exp0308 {
	private ArrayList<String> list;
	private Set<String> sets;
	private Properties props;
	private Map<String, String> maps;
	public Exp0308() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Exp2번 [list="+list+"],[sets="+sets+"],[props="+props+"],[maps="+maps+"]";
	}

}
