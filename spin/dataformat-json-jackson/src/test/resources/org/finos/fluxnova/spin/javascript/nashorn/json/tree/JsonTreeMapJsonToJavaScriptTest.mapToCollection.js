desiredType = tools.jackson.databind.type.TypeFactory.createDefaultInstance().constructCollectionType(collectionType, mapToType);

result = S(input, "application/json").mapTo(desiredType.toCanonical());

