# Proyecto Estructura de datos
## _Grupo #1_
## _Integrantes:_
- ✨Moises Fonseca Barboza✨
- ✨Diego Ramirez Corrales✨
- ✨Estefan Leon Cordero✨ 
- ✨Juan Diego Araya Calderon✨
## _Componentes visuales y librerias:_
>Se hizo el uso de JDialog nos permite crear
>ventanas emergentes que nos van a ayudar a movernos a 
>traves del menu y sus distintas opciones.

>Se hizo el uso de Java Swing nos permite crear
>Menu del proyecto con el uso de botones, ventanas, paneles etc
![Screenshot_3](https://github.com/judiarca/-2023_3C_SC-304_HE_J_G1/assets/92670091/8a2b5b3e-8c59-460a-9b53-44aa38ec51a0)
![Screenshot_2](https://github.com/judiarca/-2023_3C_SC-304_HE_J_G1/assets/92670091/4cb89dc0-f50d-4c84-bd5c-1c9bac193cbb)


>Libreria Gradient se utilizara para hacer una serie de efectos
>visuales y hacer el proyecto mas atractivo a la vista


## _Documentacion de menu de usuario y sus opciones:_
>Se aplicara la libreria ini4j para realizar
>la carga de configuraciones guardadas en formato .ini

## _Opciones de interfaz de usuario:_
>1) Agregar pasajero: Nos despliega una ventana que nos permite agregar pasajeros
>uno por uno a el tren

>2) Cargar pasajeros: Esta opcion nos permite hacer una carga de varios pasajeros
>a la vez con sus distintos datos desde un archi CSV

>3) Ver lista: Con esta opcion podemos visualizar las colas de espera de las distintas
>estaciones con sus pasajeros

>4) Ver vagon: Nos despliega una ventana que nos permite ver el tren antes de que inicie el recorrido programado

>5) Acerca de: Nos muestra un pop up que describes datos generales del proyecto

>6) Configuracion: Esta ventana nos muestra la carga la cual el tren esta utilizando actualmente   

## _Diagrama de clases_

[[LINK](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=diagramaFinal.drawio#R7Z1rc9u2EoZ%2FjWbaM9OOSOr60ZYTN62TuHWOe755YAmWGVOESlJJnF9%2FAIqkKGEFErQIpPTOZCYSTN34LIDdF4tFz5utvl1GZP34ni1o0HP7i28976Lnuk5%2FOOX%2FiZbnbcvIcbcNy8hfZBftGm787zR%2FZda68Rc03rswYSxI%2FPV%2B45yFIZ0ne20kitjX%2FcseWLD%2FqWuypFLDzZwEcuvf%2FiJ53LZO3PGu%2FTfqLx%2FzT3ZG2Q9ekfzi7JfEj2TBvpaavDc9bxYxlmwfrb7NaCBuXn5f%2Fn73%2FHdw9TS6%2FP3P%2BB%2Fy3%2FM%2FPn24%2FWX7Zm91XlL8hIiGSeO3%2Fv708Pa328Hn%2F62v3%2F75tX95dv%2F7L9lL%2Bl9IsMnu14wFJPu9yXN%2BE%2BOv%2FiogIX92%2FsDC5Cb7C78F5yTwlyF%2FPOffjUa84QuNEp%2Ff%2F7PsDwlb89b5ox8srsgz24hfECdk%2FpQ%2FO39kkf%2Bdvy0J%2BJ8c3sD%2FHCWZKbmjvStuxCt5c5%2B3RjTm11znt8Upmq5InGTXzFkQkHXs36dfWFyyItHSD89ZkrBV%2FkZsEy7oIntWcE6fJBF7KixHvL4mjAyauBv0W8kUMziXlK1oEj3zS7K%2FjvoZjOf9DvR1Z7VF22PJYgde1kiynrIs3rr4tL94zyLhkt%2BD4uNc7%2BDjBvLnOSPg8ziQvY8jAecekoSei7sYl22QPyj90l1TapkaVupIVtqbub0z%2FuX6xYN15H%2FhX4I%2F%2BsAW7G6emnH%2FQVCiKTX%2BtT2nXwAsWTcHlJQsOaAPyVE7jtdk7ofLq%2FSai8Gu5a%2FsDokmxl%2F7EKQ29OgvFjRMbSwhCdmaofgWa%2BaHSXoLh%2Bf8H%2F8Js%2F6vw96Qf6EZf%2B7snvN%2F4vIombGQmyPxU7uj3Ma%2FUmHngEUq%2B3q1RT7vk66ywEOLKBvgninocnebc%2FdDEqRDWbfRK0aux2QVZA%2FbMpCha9lAPC0DEXeP00%2FnFbSK1qxiPLFsFQPZKg4JB37qzGR3wwEn%2Bgr8Kw5SvF3O%2B5Mwh4tfHMkmPNkmPIB%2FQO5pcM1iP%2FGZeP9oe%2B2BXdiaC5z%2BoB7VSUtQhxLU9eY%2B8OcHA%2F%2BSJm%2FTOf%2BnnzvXrVtj6xgcx5%2Bjz09%2FDPpvouXm3dWUPV5e3iyBMGQ7fB9FnE%2FvnaUs0asL%2Fjhlz%2BC4DFKW3bmC73Zq5mRF1IdQ60Md1RyWW4Mqx2YF1C%2BMv9Lt01B03Aip1qc6rRn7t0ZVdqwLqtckJp9pxIQmSOMd3Mzf7q5X3RZt3okt01b4VveMBZSEohvHt5wAzrgaYAe2%2FSrnmHJ2MPHGOOtqgR3ZdqUc2WMukN4kEb%2Ft4h1W68hf%2BRE6ynp0p7Z9qqkMtxCxMqcqZ5vPxjHOwM2Je65tf2tS6UXHm%2FsS7bPglixZiL26PuOBbS9rXM%2FLSshVQEMcsDXQjm37WaPK7vtF%2BM44E2uCndpeSpDBXkbkgUkEjyRI9HuYINE7VYKEl2coKBIkhoBxePmFegkSzkGChDf5cRMkgKmlcBjTpfDeVkLPjFfkNnF7OVs8E26VfGDKlpbyBaaODlCVo9GotkkqMiQgE2xtfAL8Rgn8NsQPN6vblJdIxuse4ZMueWvbAZQIYdQO5IhRIvzal7y1oUJ5DBDUtla8VRpPOpD%2F5HfPldz3nloiO7E9bAO6rBTv0%2BQs8rmj19l44fRcwUSGtsDCuqwiyM%2BXQwN%2FxWfmqON0m0SDIzVdKIHBLF0gzj%2FILuRoLwTXcI4LKhpooTQGs2iBNdBDzZ038MmJBRvhriDd%2BnShdAazdIGU0P110Azxwv%2F8JO4N0q1NF0xfMEtXka2yHZXZfUJDGj2tkGt9rlD2glmubk2ufNLdJOkSKMKtCRfKYDALV5auroTjdDfzo%2FkmINHdBRO3FJX2KqW9wjqOi%2B9HlfZJM6G92CnbCaEdtlpVakY5SV1kZ9BItHRRba1leIpu%2F0MI6nCOOpAx98qU1Baw1tXHTyClwlQVngQ063TQkwCE1RZAj2xHeq4iFthl2fhhzH87iT5G%2FL7zKbaDvFtDbFI8hxHLwfxhGJ9nR169Zom1CVz7Crqr2IxQ2nryz8bn%2Ffc69bKw%2B%2BoQtq6iu4CKDidCvuoNJ43gWtfR3eoFsAWNydrnvtZfNF5THg0u2Fv%2F9eZFNuJsXVHPY%2FYS51KCGWo2PdOazWF2pAfUcwJNxBl3XrXxgHSLI2lyTyvUa%2BR%2B%2FuPqNQN5HDqGNlslQL4afE0mNsLfT1ZuJHqox%2BliNZjaCH89hUpTuBEddAhPJMJV0LWu0HjAKolU6eWPV7sY34SpfWFmoMhZLaC%2Bf90r8Y3IWhdk8kSPg1guW8qsF8u94lLAp4%2FlDksBD4ZALAfWAm621e0HrQUMG6vsOpRk4XX%2BEJ18qYNrBXFGt08P5BWdci5F7C83%2Fiuo46yzh60FMzBZzRcuQyW7jWUzIGJW8VmE6E%2BO3mTJXvj7qdLvt96lWBCa82j6I4%2BlUxxoBKc1gtolftsro6ES8%2Fat4II%2F8MNOzvO2zcCr6Wy2NxjIC8QSZNT8tLkOa7p5bYl%2BA8XScDHPo3KgQdR68d%2BBom5ZKSpb0iR%2Fhnw1%2BFovAzxQCLkHJdlv8iANCWtE3vZL%2FyqKTOwqESDcJnCtl%2F8d1iozgUNzE8nMdsScqzU1huazTDhBwBqArRcBHirWyEs1YpCtNlv75X6HilCoWEt9syd4IWANwNZr%2FQ4VgZEEONOykLAGYfslf2Xf6tqvv16Ouc%2FHzOHl%2B9XduqnPw7573Dq6kfo8AtzEQlIvJJqtMLlbPsckWaCv%2F7hJ0CPAVTysS0a%2B3eQHn3aMa9vrJRX0radIj6vpb%2BEh%2BdOSr5tF3V6%2Fx5NuW8AKroObzI4fqbZAd3On5IkS46vIWk%2BiHlWfFLLdG9tBxu1htZ5BPVLoOfvnZSJdbbrW97SPqk%2Fnwj3tL%2BdsfU%2F7SLHajYUpXhYiWy8Sm%2B9yx%2BPXTg%2FXeqXYca29aVsJBMnqKFu2Patc5z9O9jWfXdyIKbSybZZprfPG%2FfjtJgiQbH2y4Lq2WbLVpfliHIiboIVWtM2iVSgXxRT7ia2RqgZVaBXbLNXqcm0xYtXFCh1baxZrZfrJXKQERDMiKCzIAvHWxztwrTtQCqGivBme0icEqwEWKrNgFOxEEcfeJBG%2F771dceOOLgW1h3ds24eayMHsbX4m7yFGzBszXzNzWDeAegU1MydykC7ZKOYWHOniL04Vayu1YCKr4JcbEpI5%2F%2B1UjNWiB7zl%2F%2FrlQivpUXlnAfm8oSLDdXeVI1115a%2F4fS9d4kqXzPhIQ5asfJEnXfQbjejC3%2FuwgXTRDQl%2FZ%2FH2e4srhtIV1xvh5tKQ38jSO41w0qxrsF5NX9fJj1g8vcnKzm6eOF930sTiZCecNA%2BLk02ASQxMxff6jSbNf1Nxsqk8vO5SMbm1JPuefMhW9xHtdTAz8wXj0VR7AjW672OqqiW%2B1VYW2wOg%2BezVQbJt59xW8LdepGwqx3BStrVPV2ssTXR6%2BNbLlE2rU%2B3zAlWI%2F%2BT47Rcom2JQ3AbXuhXH2oqKp4q1zTzWQKVVB6j1gVqxrlm430uafEg9cM42VQuQcG3C1kuPTeUlzi1EOSvhIvfHsQ9rELZefGxa5xSJT6mvjWA1ImjrNcecPiCT5GRllST3qO%2B2Lchag7X1EmROv05qNjpZTZQw206W05fDoV36ST1pHtezTyjNH9RBGQOnsXuQUj5udmzIv2k52%2BkDRaX3%2FUUablZZwLcQ6VO98fmbD3ezj1dnoten14rnZ%2B%2FfffjIW2Yf319fvfl0dvExCx7GFzh4HY4NOjo%2BaJotDl6KEDEzBR44zPMMya1B3LwrbOFDh7m3LfRVWQeg8pu2DiCDtlB6X8ECnm0LAKR%2BwxbgAEHKodYvxoUOwj9RNY4qxpCebxpy9WpuHpvcdffgmRYRA9K%2BacRufcQdPlWmRcbAwSKmGavWZQ%2B8uEX%2BNHXzkbQO6TyB3SJpYIdpQboI3WiMcLUjsr59l0t1CtxuZ%2FicrdYBRcLahIFkXtNhlbymIwHEBIoGakpNN6utDArHUaRQgAvu2G3rw7U%2FMNfaJo5s9dkCxVhMs611VAHuEdcDC9ViMQ1WkT%2Bx67RIVpcsUIrFMFkXkCaPrqnf4fkx%2BoyBwiymGSvyJkq9FyE3hwyUaTENGdAmj3dkPCdIHzJUrMU05FoHuSHll1AGKreYpqwofXegQG9TknciNKLWQQ1UcTGNWhENFxJ0NnAjXb3Ej%2FxELot0FdVJd8M1duDGiF37blf1KRwxdt8mbIf2vS2FnIUnXTdhCmT1GmbqKfSOYnGB3Sc0pBH2Wm3Co751l8qTA%2BGD7OzduDwrln%2BRsg7l%2FB5bpKzQtMqF39G5agx5aN%2B5Uiw7lPb0IVYdrBPrfpUnq1if%2BK%2BSIOI%2Br%2Fb3eQ3z8%2BaKcw2hzdoDT7aPQe7MdXinl6dKEbyMyEMqz6T%2FY%2FqY3MV1tmyBNtbiGKTKD5yxgPTyg8x5XyZxLqnTuIugW9%2BhU2EOUCU2w%2BYAyDiFOdySpSgQyv%2B4xGJcbfCHirEZ5g%2Fo8EeqsZ3Nk43wGbpnBqfaq1VBG6y9Zhi3aktm6QjH8D374q98%2FntxgtdjDNVhM8wYCB6PdGkac0eVRZG%2FIJ2c31vkDGzYMsx5ACi6BecrUa%2FrbuZH801AorsLdp%2FGIoFoziV8RK6HHNi5ZRq5LP4VcpA4fSDy4znH6vbTv4nzB%2F7ZMHFX%2FrN7%2BGtE15QkP02cn5G%2FVuwGbO4yzV%2BW%2BEtyoLj3IP29Jzn%2FwQT56%2FGHznEwzF8WECWAuPWrgSpT02lrbevXQJH5Bq%2FOCuEY9X8tyPaHb0VaFPLU5QmdwW2YZ3UOVLRBqjpUwfO3DVNVSWLFYHxPPpOoiKTehFh%2Bswlt6Ehuw7RrFSmLN%2Fc%2B0n4pbeiobsO0q%2FdzkmVEl7uujaSbkIZO7zZLegioYwekFzT1p9Hz0qQLHt5tmK4iC0465HkbMF1QcdhzfEEDBK4LHDrU2yzwkQw8W50%2BoIi5U8ZrZPOxtqZ9eLkhdTh1aiRrtLgs85LBqeJIevspVSNV5UQx6Yifyf%2F7wPaSsmOni6BbT6mpMAf7KVUjVe6kwhxcNIfTm4P9DKuRKuGyZA77xtBFWzhVmlUF8h8gzWose6sSTVyn0ydbN7mqtXW6XMGC4s40HsG4Uoun9dF5rCgskw3OS5pcQ94botZBDR12aRi1Yo19tzMWUb8Ydd2NVC2iViy0q3u1i6h1Ym%2FoHEzDqGvVIUHUL0YNHYNpGLWiZtR%2Br94HjZy15DT7Ppmi%2FMx%2Bl0bOzTnbT58aKxbjd3uR9lIvELEG4jZzqfjTiIl88t3aSUTWj%2B%2FZgoor%2Fg8%3D)].

