import React from 'react';
import Wrapper from "../../Wrapper/Wrapper";
import {LIST_OF_SERVICES_ROUTE} from "../../../util/consts";

function CorrectTime() {
    return (
        <Wrapper>
            <h1>ВЫ ЗАПИСАНЫ</h1>
            <p className="text-center text-light">
                <a href={LIST_OF_SERVICES_ROUTE} className="text-light">Создать еще одну запись</a>
            </p>
        </Wrapper>
    );
}

export default CorrectTime;
