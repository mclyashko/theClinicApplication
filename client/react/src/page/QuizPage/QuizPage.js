import React, {useEffect, useState} from 'react';
import PatientNavbar from "../../component/PatientNavbar/PatientNavbar";
import Wrapper from "../../component/Wrapper/Wrapper";
import questionsRequest from "../../util/request/patient/questionsRequest";
import './QuizPage.css'
import sendQuizRequest from "../../util/request/patient/sendQuizRequest";

function QuizPage(props) {
    const [questions, setQuestions] = useState([])

    useEffect(() => {
        alert(
            'Ответьте на все вопросы, чтобы получить корректную рекомендацию. ' +
            'Ваши ответы обрабатываются на сервере, но не сохраняются ' +
            'и не используются каким-либо образом в дальнейшем.'
        )

        questionsRequest().then(questions => {
            questions.forEach(question => {
                question.choose = 1
            })
            setQuestions(questions)
        })
    }, [])

    return (
        <div>
            <PatientNavbar/>
            <Wrapper>
                <h1 className="bg-danger text-light" style={{ borderRadius: '15%', textAlign: 'center' }}>
                    Квиз! Ответьте на вопросы, чтобы получить персональную рекомендацию
                </h1>
                <form style={{ margin: '15px' }}>
                    {
                        questions.map(question => {
                            return (
                                <div key={question.id} style={{ margin: '15px' }}>
                                    <Wrapper>
                                        <p className="title">{question.title}</p>
                                        <div className="option">
                                            <label>
                                                <input checked={question.choose === 1}
                                                       onChange={ async() => {
                                                           let questionsCopy = [...questions]
                                                           questionsCopy[question.id - 1].choose = 1
                                                           setQuestions(questionsCopy)
                                                       }}
                                                       required type="radio" name={question.id} value={"1"}/>
                                                <span style={{ marginLeft: '5px' }}>{question.optionA}</span>
                                            </label>
                                        </div>
                                        <div className="option">
                                            <label>
                                                <input checked={question.choose === 2}
                                                       onChange={ async() => {
                                                           let questionsCopy = [...questions]
                                                           questionsCopy[question.id - 1].choose = 2
                                                           setQuestions(questionsCopy)
                                                       }}
                                                       required type="radio" name={question.id} value={"2"}/>
                                                <span style={{ marginLeft: '5px' }}>{question.optionB}</span>
                                            </label>
                                        </div>
                                        <div className="option">
                                            <label>
                                                <input checked={question.choose === 3}
                                                       onChange={ async() => {
                                                           let questionsCopy = [...questions]
                                                           questionsCopy[question.id - 1].choose = 3
                                                           setQuestions(questionsCopy)
                                                       }}
                                                    required type="radio" name={question.id} value={"3"}/>
                                                <span style={{ marginLeft: '5px' }}>{question.optionC}</span>
                                            </label>
                                        </div>
                                    </Wrapper>
                                </div>
                            )
                        })
                    }
                </form>
                <input onClick={async () => {
                    let result = await sendQuizRequest(questions)

                    alert(result.recommendation)
                }}
                    className="btn btn-secondary btn-block"
                       style={{ margin: '0 auto', display: 'block', width: '200px' }} type="submit"
                       value="Отправить"/>
            </Wrapper>
        </div>
    );
}

export default QuizPage;
