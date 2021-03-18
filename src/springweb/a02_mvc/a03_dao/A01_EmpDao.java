package springweb.a02_mvc.a03_dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import springweb.z02_vo.Dept;
import springweb.z02_vo.Emp;
// springweb.a02_mvc.a03_dao.A01_EmpDao : namespace
// emplist : id
// ArrayList<Emp> : resultMap
// (Emp sch) : resultType
import springweb.z02_vo.Emp2;
import springweb.z03_vo.EmpDept;

@Repository
public interface A01_EmpDao {
	// 여기에 있는 구성요소 하나 하나가 EmpMapper.xml에 있는 구성요소와 연동하여
	// mybatis 프레임워크에서 실제 객체를 생성해준다.
	//springweb.a02_mvc.a03_dao.A01_EmpDao
	public ArrayList<Emp> emplist(Emp sch);
	public void empInsert(Emp dto);
/*
 # dao, mapper :
 ex1) SELECT count(*) FROM emp;
 
 ex2) SELECT *
 	  FROM emp
 	  WHERE empno=${empno};
 	  
 ex3) 
	  SELECT empno
	  FROM emp
	  WHERE sal BETWEEN #{start} AND #{end}
=======================================================
ex1) SELECT * 
	 FROM dept 
	 WHERE deptno=#{deptno};
	 
ex2) SELECT deptno, max(sal) sal
	 FROM emp
	 GROUP BY deptno
	 
ex3) SELECT *
	 FROM emp
	 WHERE job = #{job}
	 
ex4) SELECT max(sal)
	 FROM emp
	 WHERE deptno = 10

*/
	public int totCnt();
	public Emp getEmp(int empno);
	public ArrayList<Emp2> searchEmp1(Emp2 sch);
	public ArrayList<Integer> searchEmp2(Emp2 sch);
	public ArrayList<Integer> searchEmp3(HashMap<String, Integer> hm);
//	ex1) SELECT * 
//	 FROM dept 
//	 WHERE deptno=#{deptno};
	public Dept getDept(int deptno);

/*
ex2) SELECT deptno, max(sal) sal
	 FROM emp
	 GROUP BY deptno
	 
ex3) SELECT *
	 FROM emp
	 WHERE job = #{job}
	 
ex4) SELECT max(sal)
	 FROM emp
	 WHERE deptno = 10
*/
	public ArrayList<Emp> maxSal();
	public ArrayList<Emp> seachJob(String job);
	public int maxSalDeptno(int deptno);

	public ArrayList<EmpDept> schEDGList(EmpDept sch);
	
	public ArrayList<String> getJobs();
	public ArrayList<Emp> getMgrs();
	public ArrayList<Dept> getDepts();
/*
	
*/
	
	
	
	
	
	
	
	
	
	
	
}
