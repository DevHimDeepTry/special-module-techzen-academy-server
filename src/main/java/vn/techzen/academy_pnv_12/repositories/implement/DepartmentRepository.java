//package vn.techzen.academy_pnv_12.repositories.implement;
//
//import org.springframework.stereotype.Repository;
//import vn.techzen.academy_pnv_12.models.Department;
//import vn.techzen.academy_pnv_12.repositories.interfaces.IDepartmentRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Repository
//public class DepartmentRepository implements IDepartmentRepository {
//    private final Map<Integer, Department> departmentMap = new ConcurrentHashMap<>();
//
//    public DepartmentRepository() {
//        // Thêm các phòng ban mẫu
//        Integer id1 = 1124124 ;
//        Integer id2 = 12412241;
//        Integer id3 = 1241241214;
//        Integer id4 = 23532523;
//
//        departmentMap.put(id1, new Department(id1, "Quản lý"));
//        departmentMap.put(id2, new Department(id2, "Kế toán"));
//        departmentMap.put(id3, new Department(id3, "Sales-Marketing"));
//        departmentMap.put(id4, new Department(id4, "Sản xuất"));
//    }
//
//    @Override
//    public List<Department> findAll() {
//        return new ArrayList<>(departmentMap.values());
//    }
//
//    @Override
//    public Department findById(Integer id) {
//        return departmentMap.get(id);
//    }
//
//    @Override
//    public Department save(Department department) {
//        if (department.getId() == null) {
//            department.setId(124124);
//        }
//        departmentMap.put(department.getId(), department);
//        return department;
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        departmentMap.remove(id);
//    }
//}
