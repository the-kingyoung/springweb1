package springdi.z01_vo;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
//springdi.z01_vo.Sensor
public class Sensor {
	// 여러가지 구조의 데이터 처리 객체.
	private Set<String> agentCodes;
	// Set형태의 데이터 collection 순서는 확보하지 못하지만,
	// 중복을 제외 처리
	private Properties addInfo;
	// 기본적인 key value의 데이터 처리..
	private Map<String, Integer> config;
	// agentCodes addInfo config
	// 선언하여 key값에 해당하는 객체를 할당하는 구조체
	public Sensor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<String> getAgentCodes() {
		return agentCodes;
	}
	public void setAgentCodes(Set<String> agentCodes) {
		this.agentCodes = agentCodes;
	}
	public Properties getAddInfo() {
		return addInfo;
	}
	public void setAddInfo(Properties addInfo) {
		this.addInfo = addInfo;
	}
	public Map<String, Integer> getConfig() {
		return config;
	}
	public void setConfig(Map<String, Integer> config) {
		this.config = config;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// agentCodes addInfo config
		return "Sensor [agentCodes="+agentCodes+"],[addInfo="+addInfo+"].[config="+config+"]";
	}
	
}
