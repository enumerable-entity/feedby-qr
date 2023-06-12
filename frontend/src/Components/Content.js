import {useEffect, useState} from 'react'
import Block from './Block'


function Content() {
    const [question, setTodo] = useState();
    const [isLoaded, setIsLoaded] = useState(false);
    let url = 'http://192.168.0.19:8084/qr/' + window.location.href.slice(-2);
    console.log(window.location.href.slice(-2))

    useEffect(() => {

            fetch(url)
                .then(response => response.json())
                .then(json => {
                    setTodo(json)
                    setIsLoaded(true)
                })
        }
        , []);

    return (
        <div className='Content'>
            {isLoaded
                ? <Block
                    question={question}
                    url={url}
                />
                : <p>Loading..</p>
            }
        </div>
    )

}


export default Content
