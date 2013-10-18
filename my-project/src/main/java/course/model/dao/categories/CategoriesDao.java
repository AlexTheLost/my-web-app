package course.model.dao.categories;

import java.util.List;

import course.model.domain.categories.Category;

public interface CategoriesDao {

    public List<Category> getAll();
}
