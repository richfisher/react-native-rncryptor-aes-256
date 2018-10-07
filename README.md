# React Native RNCryptor
It's an easy-to-use library for encrypting data with AES 256 in React Native. [RNCryptor](http://rncryptor.github.io/JNCryptor/javadoc/) developed popular and easy-to-use AES libs. Implementations are available in
[C++](https://github.com/RNCryptor/RNCryptor-cpp),
[C#](https://github.com/RNCryptor/RNCryptor-cs),
[Java](https://github.com/RNCryptor/JNCryptor),
[PHP](https://github.com/RNCryptor/RNCryptor-php),
[Python](https://github.com/RNCryptor/RNCryptor-python),
[Javascript](https://github.com/RNCryptor/rncryptor-js),
and [Ruby](https://github.com/RNCryptor/ruby_rncryptor).

## Getting started

`$ npm install react-native-rncryptor --save`
`$ react-native link react-native-rncryptor`

## Usage
```javascript
import RNCryptor from 'react-native-rncryptor';

RNCryptor.encrypt('a text', 'password').then((result)=>{
  console.log(result)
}).catch((error)=>{
  console.log(error)
})

RNCryptor.decrypt('encrypted base64', 'password').then((result)=>{
  console.log(result)
}).catch((error)=>{
  console.log(error)
})
```

## License
MIT