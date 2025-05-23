package com.canvas.configuration;

import com.canvas.handler.Handler;
import com.canvas.handler.Mapper;
import com.canvas.shape.*;
import com.canvas.validation.*;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public final class Configuration {
  @Getter(AccessLevel.NONE)
  private static Configuration instance;

  private final Mapper mapper;
  private final Handler handler;

  private Configuration() {
    this.mapper = new Mapper();
    this.handler = new Handler(createShapeMap(), createValidatorMap());
  }

  public static Configuration getInstance() {
    if (instance == null) {
      instance = new Configuration();
    }
    return instance;
  }

  private Map<ShapeType, Shape> createShapeMap() {
    Map<ShapeType, Shape> shapesMap = new HashMap<>();
    shapesMap.put(ShapeType.CANVAS, new Canvas());
    shapesMap.put(ShapeType.POINT, new Point());
    shapesMap.put(ShapeType.LINE, new Line());
    shapesMap.put(ShapeType.RECTANGLE, new Rectangle());
    shapesMap.put(ShapeType.BUCKET, new Bucket());
    return shapesMap;
  }

  private Map<ShapeType, BaseValidator> createValidatorMap() {
    Map<ShapeType, BaseValidator> validatorMap = new HashMap<>();
    validatorMap.put(ShapeType.CANVAS, new CanvasValidator());
    validatorMap.put(ShapeType.POINT, new PointValidator());
    validatorMap.put(ShapeType.LINE, new LineValidator());
    validatorMap.put(ShapeType.RECTANGLE, new RectangleValidator());
    validatorMap.put(ShapeType.BUCKET, new BucketValidator());
    return validatorMap;
  }
}
