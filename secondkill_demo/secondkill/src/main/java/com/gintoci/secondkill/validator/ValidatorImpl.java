package com.gintoci.secondkill.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Classname ValidatorImpl
 * @Description TODO
 * @Date 2020-03-05 16:31
 * @Created by gin
 */
@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

    //通过检验方法并返回检验结果
    public ValidationResult validate(Object bean){
        final ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size() > 0 ){
            //有错误
            result.setHasError(true);
//            lambda表示式遍历
            constraintViolationSet.forEach(constraintViolation->{
                String errMsg = constraintViolation.getMessage();
                String propertyName = constraintViolation.getPropertyPath().toString();
                result.getErrMsgMap().put(propertyName,errMsg);
            });
        }
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        //将hibernate valitation通过工厂方法使其实例化
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}
