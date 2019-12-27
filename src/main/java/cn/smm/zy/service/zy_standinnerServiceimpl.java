package cn.smm.zy.service;

import cn.smm.zy.Dao.zy_standinnerMapper;
import cn.smm.zy.pojo.zy_standinner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Dana on 2019/12/23.
 */
@Service
public class zy_standinnerServiceimpl {

    @Autowired
    private cn.smm.zy.Dao.zy_standinnerMapper zy_standinnerMapper;
    /*注入redis 操作集合模板*/
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 先从redis查询公告如果没有从数据库查询 再放入缓存  如果有的话直接返回
     * @return
     */
    public List<zy_standinner> findall(){
        String Notice = "Notice";
        List<zy_standinner> items = null;
        items= (List<zy_standinner>) redisTemplate.opsForValue().get(Notice);
        if(items==null||"".equals(items)){
            items = zy_standinnerMapper.selectList( new QueryWrapper<zy_standinner>().orderByDesc("kind"));
            redisTemplate.opsForValue().set(Notice,items);
            System.out.println("数据库差的公告");
        }else{
            items = (List<zy_standinner>) redisTemplate.opsForValue().get(Notice);
            System.out.println("Redis差的公告");
        }
        return items;
    }


    /**
     * 添加一条公告
     * @param zynotice
     * @return
     */
    public Integer addNotice(zy_standinner zynotice){
        int insert = zy_standinnerMapper.insert(zynotice);
        String Notice = "Notice";
        redisTemplate.delete(Notice);
        return insert;
    }


    /*制定一条公告*/
    public Integer updateTop(zy_standinner zy_standinner){
        String Notice = "Notice";
        redisTemplate.delete(Notice);
        Integer top = zy_standinnerMapper.updateById(zy_standinner);
        return top;
    }

    public zy_standinner findByinfo(Integer id){
        String Notice = "Notice";
        redisTemplate.delete(Notice);
        zy_standinner zy_standinner = zy_standinnerMapper.selectById(id);
        return zy_standinner;
    }

    /**
     * 删除一条宫傲
     * @param byid
     * @return
     */
    public Integer deledesc(Integer byid){

        int i = zy_standinnerMapper.deleteById(byid);

        return i;
    }


}
