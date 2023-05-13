import React, {useEffect, useState} from 'react';
import PatientNavbar from "../../component/PatientNavbar/PatientNavbar";
import Wrapper from "../../component/Wrapper/Wrapper";
import reviewsRequest from "../../util/request/patient/reviewsRequest";
import addReviewRequest from "../../util/request/patient/addReviewRequest";

function ReviewPage(props) {
    const [mark, setMark] = useState(5)
    const [review, setReview] = useState('')
    const [reviews, setReviews] = useState([])

    useEffect(() => {
        reviewsRequest().then(reviews =>
            setReviews(reviews)
        )
    }, [])

    return (
        <div>
            <PatientNavbar/>
            <Wrapper>
                <h1 className="bg-danger text-light" style={{ borderRadius: '15%', textAlign: 'center' }}>
                    Отзывы наших клиентов
                </h1>
                <div>
                    <h2 className="text-light">
                        Оставьте свой отзыв!
                        <form style={{ padding: '25px' }}>
                            <select value={mark} onChange={event => {setMark(event.target.value)}}
                                required id="rating" name="rating" style={{ margin: '5px', width: '15%' }} className="form-select form-select-sm" aria-label=".form-select-sm example">
                                <option value="5">5</option>
                                <option value="4">4</option>
                                <option value="3">3</option>
                                <option value="2">2</option>
                                <option value="1">1</option>
                            </select>
                            <textarea value={review} onChange={event => {setReview(event.target.value)}}
                                required id="commentary" name="commentary" placeholder="Описание" style={{ margin: '5px', width: '25%', fontSize: 'large' }} cols="40" rows="5"></textarea><br/>
                        </form>
                        <button onClick={ async () => {
                            await addReviewRequest({rating: mark, commentary: review})

                            reviewsRequest().then(reviews =>
                                setReviews(reviews)
                            )
                        }}
                            type="submit" className="btn btn-secondary btn-block" style={{ margin: '5px', width: '25%' }}>
                            Оставить отзыв
                        </button>
                    </h2>
                </div>
                {
                    reviews.map(review => {
                        return (
                            <div key={review.id} style={{ margin: '15px' }}>
                                <Wrapper>
                                    <h3>Отзыв от клиента {review.appUserName}</h3>
                                    <h3>Время публикации {review.publishingTime}</h3>
                                    <h5>Рейтинг: {review.rating}</h5>
                                    <h5>Комментарий: {review.commentary}</h5>
                                </Wrapper>
                            </div>
                        )
                    })
                }
            </Wrapper>
        </div>
    );
}

export default ReviewPage;
