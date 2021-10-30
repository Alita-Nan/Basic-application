package scau.nan.lab.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("该实体类的意义")
@Data
public class Entity {
    @ApiModelProperty("该属性的意义")
    private String something;
}
