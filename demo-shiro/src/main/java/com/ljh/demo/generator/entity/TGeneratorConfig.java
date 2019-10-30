package com.ljh.demo.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.ljh.demo.common.utils.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 代码生成配置表
 * </p>
 *
 * @author ljh
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_generator_config")
public class TGeneratorConfig extends Model<TGeneratorConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private String id;

    /**
     * 作者
     */
    @TableField("author")
    @Size(max = 20, message = "{noMoreThan}")
    private String author;
    /**
     * 基础包名
     */
    @TableField("base_package")
    @Size(max = 50, message = "{noMoreThan}")
    private String basePackage;
    /**
     * entity文件存放路径
     */
    @TableField("entity_package")
    @Size(max = 20, message = "{noMoreThan}")
    private String entityPackage;

    /**
     * mapper文件存放路径
     */
    @TableField("mapper_package")
    @Size(max = 20, message = "{noMoreThan}")
    private String mapperPackage;

    /**
     * mapper xml文件存放路径
     */
    @TableField("mapper_xml_package")
    @Size(max = 20, message = "{noMoreThan}")
    private String mapperXmlPackage;

    /**
     * servcie文件存放路径
     */
    @TableField("service_package")
    private String servicePackage;

    /**
     * serviceImpl文件存放路径
     */
    @TableField("service_impl_package")
    @Size(max = 20, message = "{noMoreThan}")
    private String serviceImplPackage;

    /**
     * controller文件存放路径
     */
    @TableField("controller_package")
    @Size(max = 20, message = "{noMoreThan}")
    private String controllerPackage;

    /**
     * 是否去除前缀
     */
    @TableField("is_trim")
    private String isTrim;

    /**
     * 前缀内容
     */
    @TableField("trim_value")
    private String trimValue;

    /**
     * java文件路径，固定值
     */
    private transient String javaPath = "/src/main/java/";
    /**
     * 配置文件存放路径，固定值
     */
    private transient String resourcesPath = "src/main/resources";
    /**
     * 文件生成日期
     */
    private transient String date = DateUtil.formatFullTime(LocalDateTime.now(), DateUtil.FULL_TIME_SPLIT_PATTERN);

    /**
     * 表名
     */
    private transient String tableName;
    /**
     * 表注释
     */
    private transient String tableComment;
    /**
     * 数据表对应的类名
     */
    private transient String className;


    public static final String ID = "id";

    public static final String AUTHOR = "author";

    public static final String BASE_PACKAGE = "base_package";

    public static final String ENTITY_PACKAGE = "entity_package";

    public static final String MAPPER_PACKAGE = "mapper_package";

    public static final String MAPPER_XML_PACKAGE = "mapper_xml_package";

    public static final String SERVICE_PACKAGE = "service_package";

    public static final String SERVICE_IMPL_PACKAGE = "service_impl_package";

    public static final String CONTROLLER_PACKAGE = "controller_package";

    public static final String IS_TRIM = "is_trim";

    public static final String TRIM_VALUE = "trim_value";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
