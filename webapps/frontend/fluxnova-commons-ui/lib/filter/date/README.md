# fxnDate filter

## Configuration:

If you need an additional format variant, you can

```
ngModule.config([
'fxnDateFormatProvider',
function(
fxnDateFormatProvider
) {
  // default format
  fxnDateFormatProvider.setDateFormat('LLLL');
  // short format
  fxnDateFormatProvider.setDateFormat('LL', 'short');
  // custom format
  fxnDateFormatProvider.setDateFormat('LL', 'foo');
}]);
```

## Useage:

Possible arguments are:

- short
- long
- normal
- or any custom registered format (see configuration)

```
{{ dateString | fxnDate }}
```

```
{{ dateString | fxnDate:'long' }}
```

Custom format (as in configuration)

```
{{ dateString | fxnDate:'foo' }}
```
