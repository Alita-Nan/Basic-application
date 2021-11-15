package scau.nan.lab.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@ApiModel("该实体类的意义")
@Data
public class Entity {
    // 第三个参数的意义是该字段在传参时是否为必要参数
    @Schema(description = "该属性的意义", example = "Kiki", required = true)
    private String something;
}
