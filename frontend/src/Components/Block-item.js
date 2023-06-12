import React from "react";
import YesNo from "./AnswerBlock/YesNo";

function BlockItem(props) {

    let {date} = props;

    return (
        <div className="BlockItem">
            <p>{date.title}</p>
            {date.type == 'YES_NO'

                ? <YesNo/>
                : Object.entries(date.answers
                ).map(([key, item], i) => (
                    <button className='Btn'>{item.title}</button>
                ))


            }
        </div>
    )
}

export default BlockItem
