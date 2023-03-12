fetch('http://localhost:8080/api/content')
.then(res => res.json())
.then(data =>console.log(data))