package springweb.a02_mvc.a03_dao;
import java.util.ArrayList;
import springweb.z02_vo.Dept;

//springweb.a02_mvc.a03_dao.A02_DeptDao
public interface A02_DeptDao {
    public ArrayList<Dept> deptList(Dept sch);
}