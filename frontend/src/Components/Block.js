import {useState} from 'react'
import $ from 'jquery'


function Block(props) {
    const [rating, setRating] = useState(0);
    const [custom, setCustome] = useState();
    const [hover, setHover] = useState(0);
    const [answers, setAnswers] = useState([])
    const [isActive, setIsActive] = useState(false);
    const [res, setRes] = useState(false)

    let body = {
        "ranking": rating,
        "customAnswer": custom,
        "questions": answers

    }

    const handleInput = event => {
        setCustome(event.target.value)

    };
    $('.Btn').on('click', function () {
        $(this).parent().children().removeClass('Btn-cliked')
    });


    const handleClick = (question, answer, e) => {
        // 👇️ toggle class on click


        e.currentTarget.classList.toggle('Btn-cliked');

        //End JQ
        const answerIndex = answers.findIndex(an => an.id === question.id);
        console.log("guestion: ", question);
        const isMultichoise = question.type === "MULTIPLE_CHOICE";
        console.log(isMultichoise);

        if (answerIndex !== -1) {
            setAnswers(prevAnswers => {
                const newAnswers = [...prevAnswers];
                if (isMultichoise) {
                    console.log("any shit");
                    const selectedOptions = getSelectedOptions(newAnswers[answerIndex].answerId, answer);

                    if (selectedOptions.length === 0) {
                        newAnswers.splice(answerIndex, 1);
                    } else {
                        console.log('Anserwwwwww')
                        newAnswers[answerIndex].answerId = selectedOptions;
                    }
                } else {
                    newAnswers[answerIndex].answer = answer;
                }

                return newAnswers;
            })

        } else {
            console.log(isMultichoise)
            if (isMultichoise) {
                const newAnswer = {
                    id: question.id,
                    type: question.type,
                    answerId: isMultichoise ? answer : answer
                }
                setAnswers(prevAnswers => [...prevAnswers, newAnswer])
            } else {
                const newAnswer = {
                    id: question.id,
                    type: question.type,
                    answer: isMultichoise ? [answer] : answer
                }
                setAnswers(prevAnswers => [...prevAnswers, newAnswer])
            }


        }
    }

    function getSelectedOptions(currentOptions, incomeId) {
        let selectedOptions = [...currentOptions];
        console.log("selectedOptions: ", selectedOptions);
        console.log("incomeId: ", incomeId)
        const optionIndex = selectedOptions.findIndex(opt => opt === incomeId);
        if (optionIndex !== -1) {
            selectedOptions.splice(optionIndex, 1);
        } else {
            selectedOptions.push(incomeId);
        }

        return selectedOptions;
    }

    console.log(answers)


    function Submit() {

        console.log(body)
        fetch(props.url, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(body)
        })
            .then(response => {
                //handle response
                console.log(response.ok);
                if (response.ok) {
                    setRes(true)
                }

            })
            .then(data => {
                //handle data
                console.log(data);
            })
            .catch(error => {
                //handle error
            });


        const requestOptions = {};


    }


    return (

        <div className='BlockWrapp'>
            <img className='backgroundImg'
                 src='https://assets.bonappetit.com/photos/6001a3a6078ff6c9c9d5269e/16:9/w_5952,h_3348,c_limit/Basically-EggDropTomatoSoup.jpg'></img>


            <div className="BlockItem">
                <h1>{props.question.ownerName}</h1>
                <h2>{props.question.pointAddress}</h2>
                <h2>{props.question.productTitle}</h2>

            </div>

            {Object.entries(props.question.questions).map(([key, item], i) => (


                <div className="BlockItem blockYes">
                    <p>{item.title}</p>
                    {item.type === 'YES_NO'

                        ?
                        <>

                            <button className={'Btn'} value='Yes'
                                    onClick={(event) => handleClick(item, true, event)}>Tak
                            </button>
                            <button className={'Btn'} value='No'
                                    onClick={(event) => handleClick(item, false, event)}>Nie
                            </button>
                        </>
                        :
                        Object.entries(item.answers).map(([key, answer], i) => (

                            <button key={item.id} className='Btn'
                                    onClick={(event) => handleClick(item, answer.id, event)}>{answer.title}</button>
                        ))
                    }
                </div>
            ))}

            <textarea onChange={handleInput} className='textArea' placeholder='Napisz własną propozycje...'
                      value={custom}/>

            <div className="star-rating">
                {[...Array(5)].map((star, index) => {
                    index += 1;
                    return (
                        <button

                            type="button"
                            key={index}
                            className={index <= (hover || rating) ? "on" : "off"}
                            onClick={() => setRating(index)}
                            onMouseEnter={() => setHover(index)}
                            onMouseLeave={() => setHover(rating)}
                        >
                            <span className="star">&#9733;</span>
                        </button>
                    );
                })}
            </div>


            <button className='Btn btn-st' onClick={(event) => Submit()}>Wyślij</button>
            {res == true &&
                <h2>
                    Thanks for your feedback!
                </h2>
            }
        </div>
    )
}

export default Block
