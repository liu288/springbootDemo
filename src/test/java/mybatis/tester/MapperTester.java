package mybatis.tester;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.DemoApplication;
import com.demo.test.bean.User;
import com.demo.test.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MapperTester {

    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void insert() {
        User user = new User();
        user.setId(999L);
        user.setName("liuxiao_999");
//        int res = userMapper.insert(user);
//        log.info("" + res);
        User user1 = userMapper.selectById(999);
        log.info(user1.toString());
    }

    @Test
    public void delete() {
        QueryWrapper<User> queryWrapper = Wrappers.<User>query();
        queryWrapper.eq("user_id", 999);
        int deleteRes = userMapper.delete(queryWrapper);
        System.out.println(queryWrapper);
        System.out.println(deleteRes);
    }

    @Test
    public void deleteBatchIds(){
        List idList = Lists.newArrayList(1, 2, 3);
        int res = userMapper.deleteBatchIds(idList);
        System.out.println(res);
    }

    @Test
    public void deleteById() {
        int res = userMapper.deleteById(99);
        System.out.println(res);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = Maps.newHashMap("user_id", 9);
        map.put("user_name", "liuxiao");
        int res = userMapper.deleteByMap(map);
        System.out.println(res);
    }
    
    @Test
    public void update() {
        User updateInfo = new User();
        updateInfo.setId(8L);  // 主键并不会一起更新
        updateInfo.setName("liuxiao_update");
        updateInfo.setAge(22);
        // UPDATE mp_user SET user_name=?, age=? WHERE (user_name = ?)
        QueryWrapper queryWrapper = Wrappers.query().eq("user_name", "liuxiao");
        userMapper.update(updateInfo, queryWrapper);
    }

    @Test
    public void updateById() {
        User updateInfo = new User();
        updateInfo.setId(8L);
        updateInfo.setName("liu_8");
        userMapper.updateById(updateInfo);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(8L);
        System.out.println(user);
    }

    @Test
    public void selectOne() {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.eq(true, "user_id", 8L);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }
    
    @Test
    public void selectBatchIds() {
        List idList = Lists.newArrayList(4, 5, 100);
        List list = userMapper.selectBatchIds(idList);
        System.out.println(list);
    }

    @Test
    public void selectList() {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.like("user_name", "liu");
        List list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = Maps.newHashMap("user_id", 8L);
        List list = userMapper.selectByMap(map);
        System.out.println(list);
    }

    @Test
    public void selectMaps() {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.like("user_name", "liu");
        List<Map<String, Object>> list = userMapper.selectMaps(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void selectObjs() {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.select("user_name", "user_id");
        queryWrapper.like("user_name", "liu");
        List<Object> list = userMapper.selectObjs(queryWrapper);
        System.out.println(list);
    }
    
    @Test
    public void selectPage() {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.like("user_name", "liu");
        IPage<User> page = new Page<>(2, 2);
        IPage iPage = userMapper.selectPage(page, queryWrapper);
        System.out.println("总条数：" + page.getTotal());
        System.out.println("当前页记录：" + iPage.getRecords());
    }
    
    @Test
    public void selectMapsPage() {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.like("user_name", "liu");
        IPage page = new Page<>(2, 2);
        IPage iPage = userMapper.selectMapsPage(page, queryWrapper);
        System.out.println("总条数：" + page.getTotal());
        System.out.println("当前页记录：" + iPage.getRecords());
    }

    @Test
    public void selectCount() {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.like("user_name", "liu");
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }

}
