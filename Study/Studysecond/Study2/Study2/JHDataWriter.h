//
//  JHDataWritter.h
//  Study2
//
//  Created by 박종훈 on 2016. 1. 30..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol JHDataWriter <NSObject>

- (void)writeData:(NSArray*)data;

@end

//public interface DataWriter {
//    public void writeData(List<Student> data);
//}
