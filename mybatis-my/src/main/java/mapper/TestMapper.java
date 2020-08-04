package mapper;

import bean.Test;

import java.util.List;

public interface TestMapper {
    Test getById(int i);

    List<Test> getAll();
}
